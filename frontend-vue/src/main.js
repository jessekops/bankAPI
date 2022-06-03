import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router'
import store from './store/store'

import Login from './components/users/Login.vue';

import HomePage from './components/HomePage.vue';
import Index from './components/accounts/Index.vue';
import AddAccount from './components/accounts/AddAccount.vue';

const routes = [

    { path: '/', component: Login },
    { path: '/login', component: Login },
    { path: '/home', component: HomePage },
    { path: '/accounts', component: Index },
    { path: '/addaccount', component: AddAccount },

];


const router = createRouter({
    "history": createWebHistory(),
    routes
})

const app = createApp(App);
app.use(router);
app.use(store);
app.mount('#app');
