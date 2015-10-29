//Load Template
tpl.loadTemplates(['header','employee-list','employee-details'], function() {
    app = new AppRouter();
    Backbone.history.start();
});


//destroy View properly
Backbone.View.prototype.close = function () {
    console.log('Closing view ' + this);
    this.remove();
    this.unbind();
};