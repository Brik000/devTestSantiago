<template>
    <div class="employee-table">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary per month</th>
            <th>Salary per year</th>
            <th>Age</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(employee, index) in employees" :key="index">
            <td>{{ employee.id }}</td>
            <td>{{ employee.employee_name }}</td>
            <td>{{ employee.employee_salary }}</td>
            <td>{{ employee.employee_anual_salary }}</td>
            <td>{{ employee.employee_age }}</td>
            
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import { mapGetters, mapMutations, mapActions } from "vuex";

  export default {
    data() {
    return {
      c: [],
      employees: []
    };
  },
  created: function() {
    this.$store.subscribe((mutation, state) => {
      if (mutation.type == "setErrorEmployee") {
        this.error = this.getErrorEmployee();
      }
      if (mutation.type == "setEmployeesToState") {
        this.c = this.getAllEmployees()
        this.loadEmployeesIntoList();
      }
    });
  },
  methods: {
    ...mapGetters(["getAllEmployees", "getErrorEmployee","getEmployee"]),
    ...mapActions(["loadEmployees", "loadIndividualEmployee"]),
    ...mapMutations(["setErrorEmployee","setEmployeesToState","setEmployee"]),
    loadEmployeesIntoList() {
      var lista = [];
      this.c.forEach((element) => {
        let miniEmployee = {
        employee_name : element.employee_name,
        employee_age : element.employee_age,
        employee_salary : element.employee_salary,
        employee_anual_salary : element.employee_anual_salary
        };
        lista.push(miniEmployee);
      });
      this.employees = lista;
    }
  }
  
  };
  </script>
  
  <style scoped>
  .employee-table {
    margin: 0 auto;
    max-width: 800px;
  }
  </style>
  