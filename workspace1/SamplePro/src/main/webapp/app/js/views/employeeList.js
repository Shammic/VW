window.EmployeeListView = Backbone.View.extend({

    tagName:'ul',

    initialize:function () {
        var self = this;
        this.model.bind("add", function (employee) {
            $(self.el).append(new EmployeeListTplView({model:employee}).render().el);
        });
    },

    render:function () {
        _.each(this.model.models, function (employee) {
            $(this.el).append(new EmployeeListTplView({model:employee}).render().el);
        }, this);
        return this;
    }
});
//create li element from the employee-list template
window.EmployeeListTplView = Backbone.View.extend({

    tagName:"li",

    initialize:function () {
        this.template = _.template(tpl.get('employee-list'));
        //action binds for the model changes
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render:function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});