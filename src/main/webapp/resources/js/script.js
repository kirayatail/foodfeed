Aloha.settings.sidebar = {
    disabled: true 
}

// Add Aloha editor on elements with editable class
Aloha.ready( function() {
    var $ = Aloha.jQuery;
    $('.editable').aloha();
});
                    