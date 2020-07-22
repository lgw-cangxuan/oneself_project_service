import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login'
import Register from '@/pages/Register'
import Forget from '@/pages/Forget'
import Home from '@/pages/Home'
import HelloWorld from '@/components/HelloWorld'
import Chat from '@/pages/Chat'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path:'/home',
      name:'Home',
      component:Home
    },
    {
      path:'/helloWorld',
      name:'HelloWorld',
      component:HelloWorld
    },
    {
      path:'/register',
      name:'Register',
      component:Register
    },
    {
      path:'/forget',
      name:'Forget',
      component:Forget
    },
    {
      path:'/chat',
      name:'Chat',
      component:Chat
    }
  ]
})
