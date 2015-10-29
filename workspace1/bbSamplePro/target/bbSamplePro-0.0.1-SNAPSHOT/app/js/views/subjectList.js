window.SubjectListView = Backbone.View.extend({

    tagName:'ul',

    initialize:function () {
        var self = this;
        this.model.bind("add", function (subject) {
            $(self.el).append(new SubjectListTplView({model:subject}).render().el);
        });
    },

    render:function () {
        _.each(this.model.models, function (subject) {
            $(this.el).append(new SubjectListTplView({model:subject}).render().el);
        }, this);
        return this;
    }
});
//create li element from the employee-list template
window.SubjectListTplView = Backbone.View.extend({

    tagName:"li",

    initialize:function () {
        this.template = _.template(tpl.get('subject-list'));
        //action binds for the model changes
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render:function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});