import React, { useState, useEffect } from 'react';
import { tasksAPI } from '../services/api';
import TaskForm from './TaskForm';
import TaskItem from './TaskItem';

const TaskList = () => {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showForm, setShowForm] = useState(false);
  const [editingTask, setEditingTask] = useState(null);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      setLoading(true);
      const response = await tasksAPI.getAll();
      setTasks(response.data);
      setError('');
    } catch (err) {
      setError('Failed to load tasks. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleCreateTask = async (taskData) => {
    try {
      const response = await tasksAPI.create(taskData);
      setTasks([response.data, ...tasks]);
      setShowForm(false);
      setError('');
    } catch (err) {
      setError('Failed to create task. Please try again.');
    }
  };

  const handleUpdateTask = async (taskId, taskData) => {
    try {
      const response = await tasksAPI.update(taskId, taskData);
      setTasks(tasks.map(task => 
        task.id === taskId ? response.data : task
      ));
      setEditingTask(null);
      setError('');
    } catch (err) {
      setError('Failed to update task. Please try again.');
    }
  };

  const handleToggleTask = async (taskId) => {
    try {
      const response = await tasksAPI.toggle(taskId);
      setTasks(tasks.map(task => 
        task.id === taskId ? response.data : task
      ));
      setError('');
    } catch (err) {
      setError('Failed to update task. Please try again.');
    }
  };

  const handleDeleteTask = async (taskId) => {
    if (window.confirm('Are you sure you want to delete this task?')) {
      try {
        await tasksAPI.delete(taskId);
        setTasks(tasks.filter(task => task.id !== taskId));
        setError('');
      } catch (err) {
        setError('Failed to delete task. Please try again.');
      }
    }
  };

  const handleEditTask = (task) => {
    setEditingTask(task);
    setShowForm(true);
  };

  const handleCancelEdit = () => {
    setEditingTask(null);
    setShowForm(false);
  };

  if (loading) {
    return (
      <div className="loading">
        <h3>Loading tasks...</h3>
      </div>
    );
  }

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h2>My Tasks</h2>
        <button
          className="btn btn-primary"
          onClick={() => setShowForm(true)}
        >
          Add New Task
        </button>
      </div>

      {error && (
        <div className="alert alert-danger">
          {error}
        </div>
      )}

      {showForm && (
        <div className="card mb-4">
          <TaskForm
            task={editingTask}
            onSubmit={editingTask ? handleUpdateTask : handleCreateTask}
            onCancel={handleCancelEdit}
          />
        </div>
      )}

      {tasks.length === 0 ? (
        <div className="empty-state">
          <h3>No tasks yet</h3>
          <p>Create your first task to get started!</p>
        </div>
      ) : (
        <div>
          {tasks.map(task => (
            <TaskItem
              key={task.id}
              task={task}
              onToggle={handleToggleTask}
              onEdit={handleEditTask}
              onDelete={handleDeleteTask}
            />
          ))}
        </div>
      )}
    </div>
  );
};

export default TaskList;
