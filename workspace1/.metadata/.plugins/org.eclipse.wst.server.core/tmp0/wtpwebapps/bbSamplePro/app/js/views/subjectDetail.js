window.SubjectDetail = Backbone.View.extend({

    tagName : "div",

    initialize : function (){
        this.template = _.template(tpl.get('subject-details'));
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
        "click .save":"saveSubject",
        "click .delete":"deleteSubject"
    },
    //Save or Update Subject.
    saveSubject : function(){
        this.model.set({
            name: $('#name').val(),
            code: $('#code').val(),
            description:$('#description').val()
        });
        //Check the validity of the model
        if(!this.model.isValid(true))return false;
        
        if (this.model.isNew()) {
            var that = this;
            //For new subject send POST request via collection.
            app.subjectList.create(this.model, {
                success: function() {
                     app.navigate('subject/'+that.model.id, false);
                }
            });
        } else {
             //For existing subject send PUT request via model.
             this.model.save();
        }
        return false;
    },
    //Delete subject
    deleteSubject : function(){
         this.model.destroy({
             success: function() {
                    window.history.back();
            }
       });
   }
});