import { createStore } from 'vuex'
import axios from "../axios-auth";
const store = createStore({
    state() {
        return {
            token: null,
            username: null,
            role: null
        }
    },
    getters: {
        isLoggedIn(state) {
            return !!state.token;
        },
        getUserName(state) {
            return state.username;
        },
        getUserRole(state) {
            return state.role;
        },
    },
    mutations: {
        authenticateUser(state, parameters) {
            state.token = parameters.token
            state.username = parameters.username
            state.role = parameters.role
        }
    },
    actions: {

        login({ commit }, parameters) {
            return new Promise((resolve, reject) => {
                axios.post("http://localhost:8080/BankAPI/login", {
                    username: parameters.username,
                    password: parameters.password,
                })
                    .then((result) => {
                        axios.defaults.headers.common["Authorization"] = "Bearer " +
                            result.data.token;

                        commit('authenticateUser', result.data);
                        localStorage.setItem('token', result.data.token);

                        console.log(result.data);

                        localStorage.setItem('role', result.data.role);
                        localStorage.setItem('username', result.data.username);



                        resolve()

                    })
                    .catch((error) => {
                        reject(error)
                    });
            })
        },
        autoLogin({ commit }) {
            const token = localStorage.getItem('token');
            const username = localStorage.getItem('username');
            const role = localStorage.getItem('role');
            if (token && username) {
                axios.defaults.headers.common["Authorization"] =
                    "Bearer " + token;
                commit('authenticateUser', {
                    token: token,
                    username: username,
                    role: role
                });
            }
        }
    }
});
export default store;
