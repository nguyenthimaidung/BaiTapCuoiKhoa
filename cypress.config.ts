// const { defineConfig } = require("cypress");

// module.exports = defineConfig({
  import { defineConfig } from "cypress";

  export default defineConfig({
  defaultCommandTimeout: 40000,
  pageLoadTimeout: 120000,
  viewportHeight: 1000,
  viewportWidth: 1024,
  e2e: {
    // setupNodeEvents(on, config){
    // },
    baseUrl: "https://admin-dev.appigv.vmo.group/"
    
      
      // implement node event listeners here
    
    },


  },
);
