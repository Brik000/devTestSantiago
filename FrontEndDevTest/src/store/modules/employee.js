import {Api} from '../../utils/api'

const api= new Api("employee")

const state = {
    employees:[],
    error:'',
    employee:'',
}
const getters = {
    getAllEmployees: state=> state.employees,
    getErrorEmployee: (state) => state.error,
    getEmployee: (state) => state.employee,
}
const actions = {
    loadEmployees: function({commit},payload){
        api.getAll('',payload)
        .then(res => {
            commit('setEmployeesToState',res.data)
        }).catch(error => {
            commit('setErrorEmployee',error)
        });
    },
    loadIndividualEmployee:function({commit},payload){

        api.get(payload.id).then(res => {
            commit('setEmployee',res.data)
        }).catch(error => {
            commit('setErrorEmployee',error)
        });
    },
}
const mutations = {
    setErrorEmployee(state, error) {
        state.error = error;
      },
    setEmployeesToState(state,employees){
        state.employees= employees
    },
    setEmployee(state,employee){
        state.employee= employee
    }
}

export default {
    state,
    getters,
    mutations,
    actions
}