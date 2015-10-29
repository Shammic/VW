var AppRouter = Backbone.Router.extend({

    //Initialize header of the page
    initialize: function() {
        $('#header').html( new HeaderView().render().el );
    },

    //define routing pattern and relevant function
    routes: {
        ""              : "list",
        "subject/new"  : "newSubject",
        "subject/:id"  : "subjectDetail"
    },

    //Display list of subject names in left panel
    list: function() {
          this.before();
    },


    before: function(callback) {
          if(this.subjectList){
                    if(callback){
                    callback();};
              } else{
                this.subjectList = new SubjectCollection();
                this.subjectList.fetch({success: function(){
                app.showView('#sidebar', new SubjectListView({model: app.subjectList}));
                if(callback){
                      callback();};
                }});
              }
    },
    //Add new subject
    newSubject : function() {
            this.before(function(){
            app.showView("#content", new SubjectDetail({model: new Subject()}));
        });
    },
    //View Subject Details
    subjectDetail : function(id){
        this.before(function() {
            var subject = app.subjectList.get(id);
            app.showView("#content", new SubjectDetail({model: subject}));
        });
     },

    showView: function(selector, view) {
        $(selector).html(view.render().el);
        this.currentView = view;
        return view;
    }

});