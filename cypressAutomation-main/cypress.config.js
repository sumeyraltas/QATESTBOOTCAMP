const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: 'is45do',
  reporter: 'mochawesome',
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
