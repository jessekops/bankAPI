import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router'
import store from './store/store'

import Login from './components/users/Login.vue';

const routes = [

    { path: '/', component: Login },
    { path: '/login', component: Login },
];


const router = createRouter({
    "history": createWebHistory(),
    routes
})

const app = createApp(App);
app.use(router);
app.use(store);
app.mount('#app');
