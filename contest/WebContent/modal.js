//-------------------------------------------------フォームを出現させる処理------------------------------------------------
$(function(){

//モーダルウィンドウを出現させるクリックイベント
$(".modal-open").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( ".modal-content-form" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( ".modal-content-form,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//リサイズされたら、センタリングをする関数[centeringModalSyncer()]を実行する
$( window ).resize( centeringModalSyncer ) ;

	//センタリングを実行する関数
	function centeringModalSyncer() {

		//画面(ウィンドウ)の幅、高さを取得
		var w = $( window ).width() ;
		var h = $( window ).height() ;

		// コンテンツ(#modal-content)の幅、高さを取得
		var cw = $( ".modal-content-form" ).outerWidth();
		var ch = $( ".modal-content-form" ).outerHeight();

		//センタリングを実行
		$( ".modal-content-form" ).css( {"left": ((w - cw)/2) + "px","top": ((h - ch)/2) + "px"} ) ;
	}
	
} ) ;



//---------------------------------------------写真を拡大表示する処理----------------------------------------------
$(function(){


//fuji1
$("#modal-open-fuji1").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-fuji1" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-fuji1,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;


//fuji2
$("#modal-open-fuji2").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-fuji2" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-fuji2,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;


//fuji3
$("#modal-open-fuji3").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-fuji3" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-fuji3,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//cat4
$("#modal-open-cat4").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-cat4" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-cat4,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//hot
$("#modal-open-hot").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-hot" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-hot,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//cat1
$("#modal-open-cat1").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-cat1" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-cat1,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//cat3
$("#modal-open-cat3").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-cat3" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-cat3,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//anemone
$("#modal-open-anemone").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-anemone" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-anemone,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//cat2
$("#modal-open-cat2").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-cat2" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-cat2,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;

//Marijuana
$("#modal-open-Marijuana").click( function(){

	//キーボード操作などにより、オーバーレイが多重起動するのを防止する
	$( this ).blur() ;	//ボタンからフォーカスを外す
	if( $( ".modal-overlay" )[0] ) return false ;		//新しくモーダルウィンドウを起動しない

	//オーバーレイを出現させる
	$( "body" ).append( '<div class="modal-overlay"></div>' ) ;
	$( ".modal-overlay" ).fadeIn( "slow" ) ;

	//コンテンツをセンタリングする
	centeringModalSyncer() ;

	//コンテンツをフェードインする
	$( "#modal-content-Marijuana" ).fadeIn( "slow" ) ;

	//[#modal-overlay]、または[#modal-close]をクリックしたら…
	$( ".modal-overlay,.modal-close" ).unbind().click( function(){

		//[#modal-content]と[#modal-overlay]をフェードアウトした後に…
		$( "#modal-content-Marijuana,.modal-overlay" ).fadeOut( "slow" , function(){

			//[#modal-overlay]を削除する
			$('.modal-overlay').remove() ;
		} ) ;

	} ) ;

} ) ;



//-----------------------------------------------------------------------------------------------------------------------	
	//リサイズされたら、センタリングをする関数[centeringModalSyncer()]を実行する
$( window ).resize( centeringModalSyncer ) ;

	//センタリングを実行する関数
	function centeringModalSyncer() {

		//画面(ウィンドウ)の幅、高さを取得
		var w = $( window ).width() ;
		var h = $( window ).height() ;

		// コンテンツ(#modal-content)の幅、高さを取得
		var cw = $( ".modal-content-pic" ).outerWidth();
		var ch = $( ".modal-content-pic" ).outerHeight();

		//センタリングを実行
		$( ".modal-content-pic" ).css( {"left": ((w - cw)/2) + "px","top": ((h - ch)/2) + "px"} ) ;

	}
	
} ) ;

	

