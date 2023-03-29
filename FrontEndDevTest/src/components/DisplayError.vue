<template>
    <div class="error-message">
      <div class="alert alert-danger" role="alert" v-if="errorCode === 429">
        <h4 class="alert-heading">{{ errorMessage }}</h4>
        <p>Please try again later.</p>
      </div>
      <div class="alert alert-danger" role="alert" v-else>
        <h4 class="alert-heading">Error {{ errorCode }}</h4>
        <p>{{ errorMessage }}</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      errorCode: {
        required: true
      },
      errorMessage: {
        required: true
      }
    }
  };
  </script>
  
  <style scoped>
  .error-message {
    margin: auto;
    width: 50%;
    padding-top: 3%;
  }
  </style>
  