<template>
    <aside class="sidebar">
      <ul class="menu">
        <li class="menu-item">
          <router-link to="/addOrder">AddOrder</router-link>
        </li>
        <li class="menu-item">
          <router-link to="bill">Bill</router-link>
        </li>
        <li class="menu-item">
          <router-link to="/position">Positon</router-link>
        </li>
      </ul>
    </aside>
  </template>
  
  <style>
  .sidebar {
    width: 200px;
    background-color: #333333;
    color: #ffffff;
  }
  
  .menu {
    list-style: none;
    padding: 0;
    margin: 20px 0;
  }
  
  .menu-item {
    margin-bottom: 10px;
  }
  
  .menu-item a {
    display: block;
    padding: 10px;
    color: #ffffff;
    text-decoration: none;
    transition: background-color 0.3s ease;
  }
  
  .menu-item a:hover {
    background-color: #555555;
  }
  
  .menu-item router-link {
    display: block;
    padding: 10px;
    color: #ffffff;
    text-decoration: none;
    transition: background-color 0.3s ease;
  }
  
  .menu-item router-link:hover {
    background-color: yellow;
  }
  </style>
  