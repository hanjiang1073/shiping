import Vue from 'vue'
import VueRouter from 'vue-router'
import LogIn from '../views/LogIn.vue'
import Position from'../views/Position.vue'
import Layout from'../layout/MainLayout.vue'
import Bill from'../views/Bill.vue'
import AddOrder from '../views/AddOrder.vue'

Vue.use(VueRouter)

const routes = [
  
  {
    path: '/',
    name: 'layout',
    component: Layout,
    children :[
      {
        path: '',
        name: 'Login',
        component: LogIn,
        meta: {
          title: 'Login',
        },
      },
      {
        path: 'position',
        name: 'Position',
        component: Position,
        meta: {
          title: 'Position',
        },
      },
      {
        path: 'bill',
        name: 'Bill',
        component: Bill,
        meta: {
          title: 'Bill',
        },
      },
      {
        path: 'addOrder',
        name: 'AddOrder',
        component: AddOrder,
        meta: {
          title: 'AddOrder',
        },
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  document.title = to.meta.title || 'Default Title'; // 设置页面标题，默认为 'Default Title'
  next();
});

export default router
