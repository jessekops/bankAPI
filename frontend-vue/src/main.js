import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router'
import store from './store/store'

//Users
import Login from './components/users/Login.vue';
import Register from './components/users/Register.vue';

import HomePage from './components/HomePage.vue';
//Accounts
import Index from './components/accounts/Index.vue';
import AddAccount from './components/accounts/AddAccount.vue';
//Transactions
import Deposit from './components/transactions/Deposit.vue';



const routes = [

    { path: '/', component: Login },
    { path: '/login', component: Login },
    { path: '/register', component: Register },
    { path: '/home', component: HomePage },
    { path: '/accounts', component: Index },
    { path: '/addaccount', component: AddAccount },
    { path: '/deposit', component: Deposit },

];


const router = createRouter({
    "history": createWebHistory(),
    routes
})

const app = createApp(App);
app.use(router);
app.use(store);
app.mount('#app');
