import React from 'react';

const TaskItem = ({ task, onToggle, onEdit, onDelete }) => {
  const formatDate = (dateString) => {
    const date = new Date(dateString);
    return date.toLocaleDateString() + ' ' + date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
  };

  return (
    <div className={`task-item ${task.completed ? 'completed' : ''}`}>
      <div className="task-header">
        <div className="task-title">
          {task.title}
        </div>
        <div className="task-actions">
          <button
            className={`btn ${task.completed ? 'btn-secondary' : 'btn-success'}`}
            onClick={() => onToggle(task.id)}
            title={task.completed ? 'Mark as incomplete' : 'Mark as complete'}
          >
            {task.completed ? '✓' : '○'}
          </button>
          <button
            className="btn btn-primary"
            onClick={() => onEdit(task)}
            title="Edit task"
          >
            Edit
          </button>
          <button
            className="btn btn-danger"
            onClick={() => onDelete(task.id)}
            title="Delete task"
          >
            Delete
          </button>
        </div>
      </div>
      
      {task.description && (
        <div className="task-description">
          {task.description}
        </div>
      )}
      
      <div className="task-meta">
        <span>Created: {formatDate(task.createdAt)}</span>
        {task.updatedAt !== task.createdAt && (
          <span> • Updated: {formatDate(task.updatedAt)}</span>
        )}
        <span> • Status: {task.completed ? 'Completed' : 'Pending'}</span>
      </div>
    </div>
  );
};

export default TaskItem;
