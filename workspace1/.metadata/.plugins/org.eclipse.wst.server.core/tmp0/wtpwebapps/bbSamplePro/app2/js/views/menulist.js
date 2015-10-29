window.MenuListView = Backbone.View.extend({

    tagName:'ul',

    initialize:function () {
        var self = this;
        this.model.bind("add", function (menu) {
            $(self.el).append(new MenuTplView({model:menu}).render().el);
        });
    },

    render:function () {
        _.each(this.model.models, function (menu) {
            $(this.el).append(new MenuTplView({model:menu}).render().el);
        }, this);
        return this;
    }
});
//create li element from the employee-list template
window.MenuTplView = Backbone.View.extend({

    tagName:"li",

    initialize:function () {
        this.template = _.template(tpl.get('menu-list'));
        //action binds for the model changes
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render:function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});