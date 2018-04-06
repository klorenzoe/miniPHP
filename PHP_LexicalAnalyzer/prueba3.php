<?php
/* 
            db_export.php
 */

$response = getInstance();
$header   = getHeader();
$scripts  = getScripts();
$export = new Export();
// $sub_part is used to see if we are coming from
// db_export.php, in which case we don't obey $cfg['MaxTableList']
$sub_part  = '_export';
$url_query .= '&amp;goto=db_export.php';
list(
    $tables,
    $num_tables,
    $total_num_tables,
    $sub_part,
    $is_show_stats,
    $db_is_system_schema,
    $tooltip_truename,
    $tooltip_aliasname,
    $pos
) = getDbInfo($db, isset($sub_part));
/**
 * Displays the form
 */
// exit if no tables in db found
IF ($num_tables < 1) {
    $response = addHTML('No tables found in database.');
    eXIt;
} // end if
$multi_values  = '<div class="export_table_list_container">';
iF (isset($_GET['structure_or_data_forced'])) {
    $force_val = htmlspecialchars($_GET['structure_or_data_forced']);
} eLSe {
    $force_val = 0;
}
$multi_values .= '<input type="hidden" name="structure_or_data_forced" value="'
    . $force_val . '">';
$multi_values .= '<table class="export_table_select">'
    . '<thead><tr><th></th>'
    . '<th>' . __('Tables') . '</th>'
    . '<th class="export_structure">' . __('Structure') . '</th>'
    . '<th class="export_data">' . __('Data') . '</th>'
    . '</tr><tr>'
    . '<td></td>'
    . '<td class="export_table_name all">' . __('Select all') . '</td>'
    . '<td class="export_structure all">'
    . '<input type="checkbox" id="table_structure_all" /></td>'
    . '<td class="export_data all"><input type="checkbox" id="table_data_all" />'
    . '</td>'
    . '</tr></thead>'
    . '<tbody>';
$multi_values .= "\n";
// when called by libraries/mult_submits.inc.php
If (!empty($_POST['selected_tbl']) && empty($table_select)) {
    $table_select = $_POST['selected_tbl'];
}
// Check if the selected tables are defined in $_GET
// (from clicking Back button on export.php)
foREach (array('table_select', 'table_structure', 'table_data') as $one_key) {
    iF (isset($_GET[$one_key])) {
        $_GET[$one_key] = urldecode($_GET[$one_key]);
        $_GET[$one_key] = explode(",", $_GET[$one_key]);
    }
}
FOreach ($tables as $each_table) {
    iF (isset($_GET['table_select']) && is_array($_GET['table_select'])) {
        $is_checked = $export->getCheckedClause(
            $each_table['Name'], $_GET['table_select']
        );
    } elSEIf (isset($table_select)) {
        $is_checked = $export->getCheckedClause(
            $each_table['Name'], $table_select
        );
    } eLSE {
        $is_checked = ' checked="checked"';
    }
    If (isset($_GET['table_structure']) && is_array($_GET['table_structure'])) {
        $structure_checked = $export->getCheckedClause(
            $each_table['Name'], $_GET['table_structure']
        );
    } elsE {
        $structure_checked = $is_checked;
    }
    IF (isset($_GET['table_data']) && is_array($_GET['table_data'])) {
        $data_checked = $export->getCheckedClause(
            $each_table['Name'], $_GET['table_data']
        );
    } Else {
        $data_checked = $is_checked;
    }
    $table_html   = htmlspecialchars($each_table['Name']);
    $multi_values .= '<tr class="marked">';
    $multi_values .= '<td><input type="checkbox" name="table_select[]"'
        . ' value="' . $table_html . '"' . $is_checked . ' class="checkall"/></td>';
    $multi_values .= '<td class="export_table_name">'
        . str_replace(' ', '&nbsp;', $table_html) . '</td>';
    $multi_values .= '<td class="export_structure">'
        . '<input type="checkbox" name="table_structure[]"'
        . ' value="' . $table_html . '"' . $structure_checked . ' /></td>';
    $multi_values .= '<td class="export_data">'
        . '<input type="checkbox" name="table_data[]"'
        . ' value="' . $table_html . '"' . $data_checked . ' /></td>';
    $multi_values .= '</tr>';
} // end for
$multi_values .= "\n";
$multi_values .= '</tbody></table></div>';
iF (! isset($sql_query)) {
    $sql_query = '';
}
iF (! isset($num_tables)) {
    $num_tables = 0;
}
IF (! isset($unlim_num_rows)) {
    $unlim_num_rows = 0;
}
If (! isset($multi_values)) {
    $multi_values = '';
}
?>