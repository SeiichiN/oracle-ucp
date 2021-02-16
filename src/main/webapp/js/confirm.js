'use strict';

var kakunin = function() {
  if (window.confirm("削除します。よろしいですか？")) {
    return true;
  }
  else {
    window.alert("キャンセルされました");
    return false;
  }
}

/* 修正時刻: Tue Feb 16 14:18:58 2021*/
