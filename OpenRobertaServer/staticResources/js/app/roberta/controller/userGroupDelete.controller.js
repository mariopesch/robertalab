define([ 'require', 'exports', 'log', 'util', 'message', 'comm', 'userGroup.model', 'guiState.controller', 'blocks-msg', 'jquery', 'bootstrap-table' ], function(require, exports, LOG,
        UTIL, MSG, COMM, USERGROUP, GUISTATE_C, Blockly, $) {

    function init() {
        initEvents();
        LOG.info('init user group delete');
    }
    exports.init = init;

    function initEvents() {
        /**
         * Delete the user groups those were selected in a user group list
         */
        $('#doDeleteUserGroup').onWrap('click', function() {
            var userGroup = $("#confirmDeleteUserGroup").data('userGroup');
            for (var i = 0; i < userGroup.length; i++) {
                var userName = userGroup[0][0];
                var groupName = GUISTATE_C.getGroupName();
                USERGROUP.deleteUserFromTheGroup(userName, groupName, function(userName, groupName, result) {
                UTIL.response(userName);
                if (userName.rc === 'ok') {
                    MSG.displayInformation(userName.message, groupName);
                    $('#userGroupList').find('button[name="refresh"]').trigger('click');
                    LOG.info('delete user "' + userName + "' from group '" + groupName + "'");
                }
            });
                
            }
            $('.modal').modal('hide');
        }), 'doDeleteUserGroup clicked';
    }
});
