<template>
  <div class="main-layout">
    <sidebar v-if="showSidebar" class="sidebar">
      <!-- 左侧导航栏内容 -->
    </sidebar>
    <div class="main-content">
      <!-- 主内容区域 -->
      <router-view></router-view>
    </div>
  </div>
</template>



  
  <script>
  import Sidebar from '../components/Sidebar.vue';
  export default {
    components: {
    Sidebar,
  },
    computed: {
      showSidebar() {
        // 在这里根据当前路由判断是否显示导航栏
        return this.$route.name !== 'Login'; // 假设登录页面的路由名称为 'Login'
      },
    },
  };
  </script>
  

  

  <style >
/* 主布局容器 */
.main-layout {
  display: flex;
  height: 150vh;
}

/* 侧边栏样式 */
.sidebar {
  width: 200px;
  padding: 20px;
}

/* 主内容区域样式 */
.main-content {
  flex: 1;
  padding: 20px;
  background-color:aqua;
}

/* 示例：给导航栏添加样式 */
.sidebar ul {
  list-style: none;
  padding: 0;
}

.sidebar li {
  margin-bottom: 10px;
}

.sidebar a {
  text-decoration: none;
  transition: color 0.3s ease;
}

.sidebar a:hover {
  color: #007bff;
}
</style>