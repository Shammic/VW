window.HeaderView = Backbone.View.extend({

    initialize: function() {
        this.template = _.template(tpl.get('header'));
    },

    render: function() {
        $(this.el).html(this.template());
        return this;
    },

    events: {
         "click .new"    : "newSubject"
    },

    newSubject: function() {
        app.navigate("subject/new", true);
        return false;
    }

});