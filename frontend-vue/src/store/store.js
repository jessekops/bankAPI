import { createStore } from 'vuex'
import axios from "../axios-auth";
const store = createStore({
    state() {
        return {
            token: null,
            username: null,
            userrole: null
        }
    },
    getters: {
        isLoggedIn(state) {
            return !!state.token;
        },
        getUserName(state) {
            return state.username;
        },
        isAdmin(state) {
            if (state.userrole) {
                if (state.userrole.toString().includes("ROLE_EMPLOYEE")) {
                    return true;
                }
                else {
                    return false;
                }
            }

        },
        getUserRole(state) {
            return state.userrole;
        },
    },
    mutations: {
        authenticateUser(state, parameters) {
            state.token = parameters.token
            state.username = parameters.username
            state.userrole = parameters.userrole
        }
    },
    actions: {

        login({ commit }, parameters) {
            return new Promise((resolve, reject) => {
                axios.post("login", {
                    username: parameters.username,
                    password: parameters.password,
                })
                    .then((result) => {
                        axios.defaults.headers.common["Authorization"] = "Bearer " +
                            result.data.token;

                        commit('authenticateUser', result.data);
                        localStorage.setItem('token', result.data.token);

                        console.log(result.data);

                        localStorage.setItem('userrole', result.data.userrole);
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
            const userrole = localStorage.getItem('userrole');
            if (token && username) {
                axios.defaults.headers.common["Authorization"] =
                    "Bearer " + token;
                commit('authenticateUser', {
                    token: token,
                    username: username,
                    userrole: userrole
                });
            }
        }
    }
});
export default store;
