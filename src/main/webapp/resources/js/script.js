Aloha.settings.sidebar = {
    disabled: true 
}

// Add Aloha editor on elements with editable class
Aloha.ready( function() {
    var $ = Aloha.jQuery;
    $('.editable').aloha();
});

$(document).ready(function(){
    $( ".autocomplete" ).autocomplete({
        source: "/foodfeed/grocery",
        minLength: 2
    });
    
    $(".add-ingredient").click(function(event){
        event.preventDefault();
        
        counter = $(".ingredient").length;
        
        var html = "<div class='ingredient clearfix ingredient-index-"+counter+"'>\n\
<div class='ingredient-field'>\n\
<label for='ingredients"+counter+".grocery.id'>Name</label>\n\
<input id='ingredients"+counter+".grocery.id' class='textform autocomplete ui-autocomplete-input' type='text' value='' name='ingredients["+counter+"].grocery.id' autocomplete='off'>\n\
<span class='ui-helper-hidden-accessible' role='status' aria-live='polite'></span>\n\
</div><div class='ingredient-field'>\n\
<label for='ingredients"+counter+".amount'>Amount</label>\n\
<input id='ingredients"+counter+".amount' class='textform' type='text' value='' name='ingredients["+counter+"].amount'>\n\
</div><div class='ingredient-field'>\n\
<label for='ingredients"+counter+".unit'>Unit</label>\n\
<input id='ingredients"+counter+".unit' class='textform' type='text' value='' name='ingredients["+counter+"].unit'>\n\
</div>\n\
<button type='submit' class='button remove-ingredient' name='remove-ingredient' value="+counter+">Remove</button>\n\
</div>";
        
        $(html).insertBefore('.add-ingredient');
    });
});                    