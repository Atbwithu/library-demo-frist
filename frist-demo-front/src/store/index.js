import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    // 存储状态数据
    userInfo:{},
    count: 0,
    token: localStorage.getItem('token') ? localStorage.getItem('token') : '',
  },
  mutations: {
    // 定义修改状态的方法
    increment(state) {
      state.count++;
    },
    // 用于设置特定账号信息的 mutation
    setAccountInfo(state, { account, token }) {
      state.accounts[account] = { token };
    },
    loginSuccess({ commit }, response) {
      const account = response.data.account;
      const token = response.data.token;
      commit('setAccountInfo', { account, token });
    },
    changeLogin(state, user) {
      state.token = user.token;
      localStorage.setItem('token', user.token);
    },
    userInfo(state,payload){
      state.userInfo = payload
    }
  },
  actions: {
    // 定义异步操作，可以提交 mutations
    incrementAsync({ commit }) {
      setTimeout(() => {
        commit('increment');
      }, 1000);
    }
  },
  getters: {
    // 定义计算属性，基于 state 计算得到新的值
    doubleCount(state) {
      return state.count * 2;
    }
  }
});

export default store;