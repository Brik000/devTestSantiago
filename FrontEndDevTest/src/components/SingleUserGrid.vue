<template>
  <div class="row">
    <div class="col-3">
      <img :src="profileImage" :alt="employee_name" class="img-fluid rounded-circle">
    </div>
    <div class="col-9">
      <div class="row">
        <div class="col-4">Name:</div>
        <div class="col-8">{{ employee_name }}</div>
      </div>
      <div class="row">
        <div class="col-4">Salary:</div>
        <div class="col-8">{{ employee_salary }}</div>
      </div>
      <div class="row">
        <div class="col-4">Age:</div>
        <div class="col-8">{{ employee_age }}</div>
      </div>
      <div class="row">
        <div class="col-4">Annual Salary:</div>
        <div class="col-8">{{ employee_anual_salary }}</div>
      </div>
    </div>
  </div>
</template>

  
  <script>
  import { mapGetters, mapMutations, mapActions } from "vuex";

  export default {
    props: {
      employeeId: {
        type: Number,
        required: true,
      },
    },
    data() {
    return {    
    id: "",
    profileImage: "",
    employee_name: "",
    employee_salary: "",
    employee_age: "",
    employee_anual_salary: "",
    error: "",
    };
  },
  created: function() {
    this.loadIndividualEmployee(this.employeeId);
    this.$store.subscribe((mutation, state) => {
      if (mutation.type == "setErrorEmployee") {
        this.error = this.getErrorEmployee();
      }
      if (mutation.type == "setEmployee") {
        
       
        let employee = this.getEmployee();
        this.profileImage = employee.profileImage;
        this.employee_name = employee.employee_name;
        this.employee_age = employee.employee_age;
        this.employee_salary = employee.employee_salary;
        this.employee_anual_salary = employee.employee_anual_salary;
      }
    });
  },
  methods: {
    ...mapGetters(["getAllEmployees", "getErrorEmployee","getEmployee"]),
    ...mapActions(["loadEmployees", "loadIndividualEmployee"]),
    ...mapMutations(["setErrorEmployee","setEmployeesToState","setEmployee"]),
  }
  };
  </script>

  