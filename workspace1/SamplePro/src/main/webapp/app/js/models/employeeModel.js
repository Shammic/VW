window.Employee= Backbone.Model.extend({
    urlRoot :"employee/api",
    defaults: {
        "id": null,
        "name":  "",
        "address":  "N/A",
        "city":  "N/A",
        "school":  "",
        "description":  "",
        "email":  "",
        "picture":  "person.jpg"
      },
      validation: {
    	    name: {
    	      required: true,
    	      msg: 'Please enter a name'
    	    },
    	    address: {
    	      required: true,
    	      msg: 'Please enter a address'
      	    },
      	    email: {
              required: true,
              pattern: 'email'
            }
      }
});

window.EmployeeCollection = Backbone.Collection.extend({
    model: Employee,
    url: "employee/api"
});