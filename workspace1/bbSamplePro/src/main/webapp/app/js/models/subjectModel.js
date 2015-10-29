window.Subject= Backbone.Model.extend({
    urlRoot :"subject/api",
    defaults: {
        "id": null,
        "name":  "",
        "code":  "",
        "description":  ""
      },
      validation: {
    	   name: {
    	      required: true,
    	      msg: 'Please enter a name'
    	    },
    	    code: {
    	      required: true,
    	      msg: 'Please enter a code'
      	    }
      }
});

window.SubjectCollection = Backbone.Collection.extend({
    model: Subject,
    url: "subject/api"
});