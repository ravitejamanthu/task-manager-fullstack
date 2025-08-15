import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = ({ isAuthenticated, user, onLogout }) => {
  return (
    <nav className="navbar">
      <div className="container">
        <div className="d-flex justify-content-between align-items-center">
          <Link to="/" className="navbar-brand">
            Task Manager
          </Link>
          
          <ul className="navbar-nav">
            {isAuthenticated ? (
              <>
                <li>
                  <Link to="/tasks" className="nav-link">
                    My Tasks
                  </Link>
                </li>
                <li>
                  <span className="nav-link">
                    Welcome, {user?.username}!
                  </span>
                </li>
                <li>
                  <button 
                    onClick={onLogout} 
                    className="btn btn-outline-secondary"
                    style={{ 
                      background: 'transparent', 
                      border: '1px solid #6c757d', 
                      color: '#6c757d' 
                    }}
                  >
                    Logout
                  </button>
                </li>
              </>
            ) : (
              <>
                <li>
                  <Link to="/login" className="nav-link">
                    Login
                  </Link>
                </li>
                <li>
                  <Link to="/register" className="nav-link">
                    Register
                  </Link>
                </li>
              </>
            )}
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
