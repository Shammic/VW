var AppRouter = Backbone.Router.extend({

    //Initialize header of the page
    initialize: function() {
        $('#header').html( new HeaderView().render().el );
    },

    //define routing pattern and relevant function
    routes: {
        ""              : "list",
        "employee/new"  : "newEmployee",
        "employee/:id"  : "employeeDetail"
    },

    //Display list of employee names in left panel
    list: function() {
          this.before();
    },


    before: function(callback) {
          if(this.employeeList){
                    if(callback){
                    callback();};
              } else{
                this.employeeList = new EmployeeCollection();
                this.employeeList.fetch({success: function(){
                app.showView('#sidebar', new EmployeeListView({model: app.employeeList}));
                if(callback){
                      callback();};
                }});
              }
    },
    //Add new employee
    newEmployee : function() {
            this.before(function(){
            app.showView("#content", new EmployeeDetail({model: new Employee()}));
        });
    },
    //View Employee Details
    employeeDetail : function(id){
        this.before(function() {
            var employee = app.employeeList.get(id);
            app.showView("#content", new EmployeeDetail({model: employee}));
        });
     },

    showView: function(selector, view) {
        $(selector).html(view.render().el);
        this.currentView = view;
        return view;
    }

});