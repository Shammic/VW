window.EmployeeDetail = Backbone.View.extend({

    tagName : "div",

    initialize : function (){
        this.template = _.template(tpl.get('employee-details'));
        this.model.bind("change",this.render,this);
        this.model.bind("destroy", this.close, this);
        Backbone.Validation.bind(this,{
            valid: function (view, attr, selector) {
                var $el = view.$('[name=' + attr + ']'), 
                    $group = $el.closest('.form-group');
                
                $group.removeClass('has-error');
                $group.find('.help-block').html('').addClass('hidden');
            },
            invalid: function (view, attr, error, selector) {
                var $el = view.$('[name=' + attr + ']'), 
                    $group = $el.closest('.form-group');
                
                $group.addClass('has-error');
                $group.find('.help-block').html(error).removeClass('hidden');
            },
            forceUpdate: true
            });
    },
    
    render: function(){
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },
    //Define Events and relevant actions.
    events : {
        "click .save":"saveEmployee",
        "click .delete":"deleteEmployee"
    },
    //Save or Update Employee.
    saveEmployee : function(){
        this.model.set({
            name: $('#name').val(),
            address: $('#address').val(),
            city: $('#city').val(),
            school:$('#school').val(),
            description:$('#description').val(),
            email:$('#email').val()
        });
        //Check the validity of the model
        if(!this.model.isValid(true))return false;
        
        if (this.model.isNew()) {
            var that = this;
            //For new employee send POST request via collection.
            app.employeeList.create(this.model, {
                success: function() {
                     app.navigate('employee/'+that.model.id, false);
                }
            });
        } else {
             //For existing employee send PUT request via model.
             this.model.save();
        }
        return false;
    },
    //Delete employee
    deleteEmployee : function(){
         this.model.destroy({
             success: function() {
                    window.history.back();
            }
       });
   }
});