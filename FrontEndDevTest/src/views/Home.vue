<template>
  <div >
  <menu-bar>
  </menu-bar>
  <search v-on:responseReceived="handleResponse"></search>
  <template v-if="response === '' && !flagFirstReq && !errorFlag">
    <employee-table />
  </template>
  <template v-else-if="response !='' &&!flagFirstReq && !errorFlag">
    <single-user-grid :employee-id="this.response"/>
  </template>
  <template v-else-if="errorFlag">
    <error-message :error-code="error.message" :error-message="error.detail" />
  </template>

  </div>
</template>

<script>
import Menu from "../components/Menu";
import Search from "../components/Search";
import SingleUserGrid from "../components/SingleUserGrid";
import ErrorDisplay from "../components/DisplayError";
import AllUsersGrid from '../components/AllUsersGrid.vue';
import { mapGetters, mapMutations, mapActions } from "vuex";


export default {
  components: {
    "menu-bar": Menu,
    "search": Search,
    "single-user-grid":SingleUserGrid,
    "error-message":ErrorDisplay,
    "employee-table":AllUsersGrid
  },
  data() {
    return {
      errorFlag:false,
      flagFirstReq:true,
      response: "", 
      error: {
        message: "",
        detail: ""
      }
    };
  },
  methods: {
    ...mapGetters(["getAllEmployees", "getErrorEmployee","getEmployee"]),
    ...mapActions(["loadEmployees", "loadIndividualEmployee"]),
    ...mapMutations(["setErrorEmployee","setEmployeesToState","setEmployee"]),
    handleResponse(response) {
      this.flagFirstReq=false;
      if(response !=''){
        this.response = Number(response)
      }else if (response === ''){
        this.response ='';
      }
    }
  },created: function() {
    this.$store.subscribe((mutation, state) => {
      console.log(mutation.type)
      if (mutation.type == "setErrorEmployee") {
        this.error = this.getErrorEmployee();
        this.errorFlag = true;
        setInterval(() => {
          this.errorFlag=false,
          this.flagFirstReq=true
        }, 3000);
      }
    });
  },
};
</script>