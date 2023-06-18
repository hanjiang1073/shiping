import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    id: '',
    token: ''
  },
  mutations: {
    setUserData(state, { id, token }) {
      state.id = id;
      state.token = token;
    },
    clearUserData(state) {
      state.id = '';
      state.token = '';
    }
  },
  actions: {
    login({ commit }, { id, token }) {
      // 在登录成功后调用该方法保存用户名和 token
      commit('setUserData', { id, token });
    },
    logout({ commit }) {
      // 在退出登录时调用该方法清除用户名和 token
      commit('clearUserData');
    }
  },
  getters: {
    isAuthenticated: state => !!state.token
  }
});

export default store
