<template>
  <div class="employee-search">
    <b-form @submit.prevent="searchEmployee" class="d-flex align-items-center">
      <b-form-input v-model="employeeId" id="employee-id" type="text"
        placeholder="Enter Employee ID or find all employees" class="flex-grow-1 mr-2"></b-form-input>
      <b-button type="submit" variant="primary">Search</b-button>
    </b-form>
  </div>
</template>
  
<script>
import { mapGetters, mapMutations, mapActions } from "vuex";

export default {
  data() {
    return {
      employeeId: ''
    }
  },
  methods: {
    ...mapGetters(["getAllEmployees", "getErrorEmployee", "getEmployee"]),
    ...mapActions(["loadEmployees", "loadIndividualEmployee"]),
    ...mapMutations(["setErrorEmployee", "setEmployeesToState", "setEmployee"]),
    searchEmployee() {
      let payload = {
          id: this.employeeId
        }
      if (isNaN(this.employeeId)) {
        alert('Textbox can only contain numerical values');
        this.employeeId = '';
        return;
      } else if(this.employeeId===''){
        this.loadEmployees();
      }else{
        this.loadIndividualEmployee(payload);
        }
        this.$emit('responseReceived', this.employeeId);
        return;
      }
    }
  }

</script>

<style scoped>
.employee-search {
  margin: auto;
  width: 30%;
  padding-top: 3%;
}
</style>
