//Load Template
tpl.loadTemplates(['header','subject-list','subject-details'], function() {
    app = new AppRouter();
    Backbone.history.start();
});


//destroy View properly
Backbone.View.prototype.close = function () {
    console.log('Closing view ' + this);
    this.remove();
    this.unbind();
};