import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const LOGIN = "LOGIN";
const LOGIN_SUCCESS = "LOGIN_SUCCESS";
const LOGOUT = "LOGOUT";

export const store = new Vuex.Store({
  state: {
    nom:'',
    isLoggedIn: localStorage.getItem("token")
  },
  mutations: {
    change(state, nom) {
      state.nom = nom
    },
    [LOGIN](state) {
      state.pending = true;
    },
    [LOGIN_SUCCESS](state) {
      state.isLoggedIn = true;
      state.pending = false;
    },
    [LOGOUT](state) {
      state.isLoggedIn = false;
    }
  },
  actions: {
    login({
      state,
      commit,
      rootState
    }, creds) {
      console.log("login...", creds);
      commit(LOGIN); // show spinner
      return new Promise(resolve => {
        setTimeout(() => {
          localStorage.setItem("token", "JWT");
          commit(LOGIN_SUCCESS);
          resolve();
        }, 1000);
      });

    },
    logout({
      commit
    }) {
      localStorage.removeItem("token");
      commit(LOGOUT);
    }
  },
  getters: {

      nom: state => state.nom
    ,
    isLoggedIn: state => state.isLoggedIn
    }
  

})
