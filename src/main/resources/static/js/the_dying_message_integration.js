//ytplayer code: 
//https://developers.google.com/youtube/player_parameters#IFrame_Player_API
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/player_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
var follow = false;
var promise_time = 500; // more than 500 is going to take too much CPU resources
var timer = setTimeout(() => follow_player_time, promise_time);
var the_dying_message_lyrics_box = document.getElementById("the_dying_message_lyrics_box");

function follow_player_time() {
  console.log("Current time: " + player.playerInfo.currentTime);
// thanks to this guy's replay:
// https://stackoverflow.com/questions/21808543/multple-criteria-in-a-single-case-inside-a-switch-statement?noredirect=1&lq=1
  
// Switch below takes the time in the player and for specific range of seconds displays
// lyrics in the song overriding over and over again the same object 


// 散漫で不安定なこの世界
// 革命を起こしてよ

// 「愛」が正解になれ

// 不安なんて簡単に消えちゃって
// 薄明の陽照らす、その向こうへ

// 記録も　記憶も　無い人　埋葬
// 希望も　未来も　無い国　外傷

// 長い夜を終え　朝焼けを見た
// 赤く染まる背中と

// ねえ　貴方はいつか　居なくなりますか
// 終わりかけのこの世界で
// 夜明け前の憂い　耐え難い孤独
// 淡い想いと寂寞を　抱いた

// 鮮明な弾丸の記憶に
// 誰もがひよっては

// 第一歩が出ない

// 安全は簡単に消えちゃって
// 悪影響及ぼした、僕の心へ
// 長い雨が止み　暑い陽射しが
// 照らす大きな背中を

// ねえ　貴方はいつも　夢を見てますか
// 終わりかけのこの世界で
// 塞がれた道を　拓く者になる
// 「メッセージ」を抱いていた　つらいよ

// 無情にも時が来て　彼方へ旅立った
// 果敢な感情構え　砕け散る為に
// 勇敢な貴方は　空を切り裂いた
// 精悍な表情構え　風になった

// 慟哭　隠して

// 寂寞　隠して

// 生きる事さえ　望めないなら
// ただ世界を感じて　息を吐く

// 長い夜を終え　背中など無い
// そこにあるのはただ　広いブルー

// ねえ　貴方はいつも　元気をくれますか
// 終わりかけのこの世界で
// 暗がりで交わした　小さな約束が
// 私の生きる糧さ
// ねえ　私は二度と　暗い顔しないよ
// 遮る影も見えぬから
// 明るい陽射しを　存分に浴びながら
// 「6日」の朝を迎えた

  switch(true){

    case (player.playerInfo.currentTime >= 20 && player.playerInfo.currentTime < 21.5):
    the_dying_message_lyrics_box.innerHTML = "Sanman de";
    break;

    case (player.playerInfo.currentTime >= 21.5 && player.playerInfo.currentTime < 22):
    the_dying_message_lyrics_box.innerHTML = "fuantei na";
    break;

    case (player.playerInfo.currentTime >= 22 && player.playerInfo.currentTime < 23.5):
    the_dying_message_lyrics_box.innerHTML = "kono sekai";
    break;

    case (player.playerInfo.currentTime >= 24 && player.playerInfo.currentTime < 26.5):
    the_dying_message_lyrics_box.innerHTML = "Kakumei wo okoshite yo";
    break;

    case (player.playerInfo.currentTime >= 27 && player.playerInfo.currentTime < 29.5):
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 30 && player.playerInfo.currentTime < 31):
    the_dying_message_lyrics_box.innerHTML = "fuan nante";
    break;

    case (player.playerInfo.currentTime >= 31 && player.playerInfo.currentTime < 33.5):
    the_dying_message_lyrics_box.innerHTML = "kankan ni kiechatte";
    break;

    case (player.playerInfo.currentTime >= 33.5 && player.playerInfo.currentTime < 35):
    the_dying_message_lyrics_box.innerHTML = "hakumei no";
    break;

    case (player.playerInfo.currentTime >= 35 && player.playerInfo.currentTime < 36.5):
    the_dying_message_lyrics_box.innerHTML = "hi terasu,";
    break;

    case (player.playerInfo.currentTime >= 36.5 && player.playerInfo.currentTime < 39.5):
    the_dying_message_lyrics_box.innerHTML = ",sono mukou hee";
    break;

    case (player.playerInfo.currentTime >= 39.5 && player.playerInfo.currentTime < 41):
    the_dying_message_lyrics_box.innerHTML = "Kiroku mo";
    break;

    case (player.playerInfo.currentTime >= 41 && player.playerInfo.currentTime < 42.5):
    the_dying_message_lyrics_box.innerHTML = "kioku mo";
    break;

    case (player.playerInfo.currentTime >= 42.5 && player.playerInfo.currentTime < 44):
    the_dying_message_lyrics_box.innerHTML = "nai hito, maishou";
    break;

    case (player.playerInfo.currentTime >= 44 && player.playerInfo.currentTime < 45):
    the_dying_message_lyrics_box.innerHTML = "kibuo mo mirai";
    break;

    case (player.playerInfo.currentTime >= 45.5 && player.playerInfo.currentTime < 48):
    the_dying_message_lyrics_box.innerHTML = "mo nai kuni, gaishou";
    break;

    case (player.playerInfo.currentTime >= 49 && player.playerInfo.currentTime < 51.5):
    the_dying_message_lyrics_box.innerHTML = "Nagai yoru wo oe";
    break;

    case (player.playerInfo.currentTime >= 51.5 && player.playerInfo.currentTime < 54):
    the_dying_message_lyrics_box.innerHTML = "asayake wo mita";
    break;

    case (player.playerInfo.currentTime >= 54 && player.playerInfo.currentTime < 57):
    the_dying_message_lyrics_box.innerHTML = "Akaku somaru senaka toooo";
    break;

    case (player.playerInfo.currentTime >= 58 && player.playerInfo.currentTime < 60.5):
    the_dying_message_lyrics_box.innerHTML = "NEE ANATA WA ITSUKA";
    break;

    case (player.playerInfo.currentTime >= 60.5 && player.playerInfo.currentTime < 63):
    the_dying_message_lyrics_box.innerHTML = "INAKU NARI MASU KA?";
    break;

    case (player.playerInfo.currentTime >= 63 && player.playerInfo.currentTime < 67):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 67 && player.playerInfo.currentTime < 68):
    the_dying_message_lyrics_box.innerHTML = "SEKAI DEEE";
    break;

    case (player.playerInfo.currentTime >= 68 && player.playerInfo.currentTime < 70.5):
    the_dying_message_lyrics_box.innerHTML = "YOAKE MAE NO UREI";
    break;

    case (player.playerInfo.currentTime >= 70.5 && player.playerInfo.currentTime < 73):
    the_dying_message_lyrics_box.innerHTML = "TAEGATAI KODOKU";
    break;

    case (player.playerInfo.currentTime >= 73 && player.playerInfo.currentTime < 76.5):
    the_dying_message_lyrics_box.innerHTML = "AWAI OMOI TO SEKIBAKU";
    break;

    case (player.playerInfo.currentTime >= 76.5 && player.playerInfo.currentTime < 77.5):
    the_dying_message_lyrics_box.innerHTML = "WO";
    break;

    case (player.playerInfo.currentTime >= 77.5 && player.playerInfo.currentTime < 79):
    the_dying_message_lyrics_box.innerHTML = "DAITAAAAAAAAA";
    break;

    case (player.playerInfo.currentTime >= 97 && player.playerInfo.currentTime < 101):
    the_dying_message_lyrics_box.innerHTML = "Senmei na dangan no kioku ni";
    break;

    case (player.playerInfo.currentTime >= 101 && player.playerInfo.currentTime < 104):
    the_dying_message_lyrics_box.innerHTML = "Dare mo ga hi yotte wa";
    break;

    case (player.playerInfo.currentTime >= 104 && player.playerInfo.currentTime < 107):
    the_dying_message_lyrics_box.innerHTML = "DAIIPO GA DE NAI";
    break;

    case (player.playerInfo.currentTime >= 107 && player.playerInfo.currentTime < 110):
    the_dying_message_lyrics_box.innerHTML = "Anzen wa kankan ni kiechate";
    break;

    case (player.playerInfo.currentTime >= 110 && player.playerInfo.currentTime < 113.5):
    the_dying_message_lyrics_box.innerHTML = "Akueikyou oyoboshi ta,";
    break;

    case (player.playerInfo.currentTime >= 113.5 && player.playerInfo.currentTime < 115.5):
    the_dying_message_lyrics_box.innerHTML = "Boku no kokoro he";
    break;
    
    case (player.playerInfo.currentTime >= 115.5 && player.playerInfo.currentTime < 118):
    the_dying_message_lyrics_box.innerHTML = "Nagai ame ga yami";
    break;
    
    case (player.playerInfo.currentTime >= 118 && player.playerInfo.currentTime < 120):
    the_dying_message_lyrics_box.innerHTML = "Atsui hizashi ga";
    break;
    
    case (player.playerInfo.currentTime >= 120 && player.playerInfo.currentTime < 123.5):
    the_dying_message_lyrics_box.innerHTML = "Tearsu ookina senaka woooo";
    break;

    case (player.playerInfo.currentTime >= 123.5 && player.playerInfo.currentTime < 125):
    the_dying_message_lyrics_box.innerHTML = "WOOOOOOO";
    break;
    
    case (player.playerInfo.currentTime >= 125 && player.playerInfo.currentTime < 130):
    the_dying_message_lyrics_box.innerHTML = "NEE ANATA WA ITSUMO YUME WO MITE MASU KA?";
    break;
    
    case (player.playerInfo.currentTime >= 130 && player.playerInfo.currentTime < 135):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO SEKAI DE";
    break;
    
    case (player.playerInfo.currentTime >= 135 && player.playerInfo.currentTime < 138):
    the_dying_message_lyrics_box.innerHTML = "FUSAGA RE TA MICHI WO";
    break;
    
    case (player.playerInfo.currentTime >= 138 && player.playerInfo.currentTime < 140):
    the_dying_message_lyrics_box.innerHTML = "HIRAKU MONO NI NARU";
    break;
    
    case (player.playerInfo.currentTime >= 140 && player.playerInfo.currentTime < 145):
    the_dying_message_lyrics_box.innerHTML = "'MESSEJII' WO IDA ITE TA TSURAI YOO";
    break;
    
    case (player.playerInfo.currentTime >= 164 && player.playerInfo.currentTime < 166.5):
    the_dying_message_lyrics_box.innerHTML = "mujou ni mo toki ga kitte";
    break;
    
    case (player.playerInfo.currentTime >= 166.5 && player.playerInfo.currentTime < 168.5):
    the_dying_message_lyrics_box.innerHTML = "kanata he tabidata";
    break;
    
    case (player.playerInfo.currentTime >= 168.5 && player.playerInfo.currentTime < 170.5):
    the_dying_message_lyrics_box.innerHTML = "KANKAN na kanjou kamae, ";
    break;
    
    case (player.playerInfo.currentTime >= 170.5 && player.playerInfo.currentTime < 173):
    the_dying_message_lyrics_box.innerHTML = "kudake chiiru tame ni";
    break;
    
    case (player.playerInfo.currentTime >= 173 && player.playerInfo.currentTime < 178):
    the_dying_message_lyrics_box.innerHTML = "YUUKAN na anata wa sora wo kirisaita";
    break;
    
    case (player.playerInfo.currentTime >= 178 && player.playerInfo.currentTime < 180):
    the_dying_message_lyrics_box.innerHTML = "SEIKAN na hyoujou kamae";
    break;
    
    case (player.playerInfo.currentTime >= 180 && player.playerInfo.currentTime < 182):
    the_dying_message_lyrics_box.innerHTML = "KAZE NI NATTAAAAAAAAAA";
    break;
    
    case (player.playerInfo.currentTime >= 182 && player.playerInfo.currentTime < 183):
    the_dying_message_lyrics_box.innerHTML = "DOU";
    break;
    
    case (player.playerInfo.currentTime >= 183 && player.playerInfo.currentTime < 184):
    the_dying_message_lyrics_box.innerHTML = "DOUKO";
    break;
    
    case (player.playerInfo.currentTime >= 184 && player.playerInfo.currentTime < 185):
    the_dying_message_lyrics_box.innerHTML = "DOUKOKU";
    break;
    
    case (player.playerInfo.currentTime >= 187.5 && player.playerInfo.currentTime < 188.5):
    the_dying_message_lyrics_box.innerHTML = "KAKUSHITE";
    break;
    
    case (player.playerInfo.currentTime >= 192 && player.playerInfo.currentTime < 193):
    the_dying_message_lyrics_box.innerHTML = "SEKI";
    break;
    
    case (player.playerInfo.currentTime >= 193 && player.playerInfo.currentTime < 195):
    the_dying_message_lyrics_box.innerHTML = "SEKIBA";
    break;
    
    case (player.playerInfo.currentTime >= 195 && player.playerInfo.currentTime < 196):
    the_dying_message_lyrics_box.innerHTML = "SEKIBAKU";
    break;
    
    case (player.playerInfo.currentTime >= 197 && player.playerInfo.currentTime < 198.5):
    the_dying_message_lyrics_box.innerHTML = "KAKUSHITE";
    break;
    
    case (player.playerInfo.currentTime >= 203 && player.playerInfo.currentTime < 205):
    the_dying_message_lyrics_box.innerHTML = "ikiru koto sae";
    break;
    
    case (player.playerInfo.currentTime >= 205 && player.playerInfo.currentTime < 207):
    the_dying_message_lyrics_box.innerHTML = "nozome nai nara";
    break;
    
    case (player.playerInfo.currentTime >= 207 && player.playerInfo.currentTime < 211):
    the_dying_message_lyrics_box.innerHTML = "tada sekai wo kanjite iki wo haku";
    break;
    
    case (player.playerInfo.currentTime >= 211 && player.playerInfo.currentTime < 217):
    the_dying_message_lyrics_box.innerHTML = "nagai senaka nado nai";
    break;
    
    case (player.playerInfo.currentTime >= 217 && player.playerInfo.currentTime < 220):
    the_dying_message_lyrics_box.innerHTML = "soko ni aru no wa tadaaaa";
    break;
    
    case (player.playerInfo.currentTime >= 221 && player.playerInfo.currentTime < 222):
    the_dying_message_lyrics_box.innerHTML = "HIROIIIII";
    break;
    
    case (player.playerInfo.currentTime >= 222 && player.playerInfo.currentTime < 223):
    the_dying_message_lyrics_box.innerHTML = "BURUUUUUUU";
    break;
    
    case (player.playerInfo.currentTime >= 223 && player.playerInfo.currentTime < 228):
    the_dying_message_lyrics_box.innerHTML = "NEE ANATA WA ITSUMO GENKI WO KURE MASU KA?";
    break;
    
    case (player.playerInfo.currentTime >= 228 && player.playerInfo.currentTime < 232):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO SEKAI DE";
    break;
    
    case (player.playerInfo.currentTime >= 232 && player.playerInfo.currentTime < 237.5):
    the_dying_message_lyrics_box.innerHTML = "KURAGARI DE KAWASHITA CHIISANA YAKUSOKU GA";
    break;
    
    case (player.playerInfo.currentTime >= 237.5 && player.playerInfo.currentTime < 243):
    the_dying_message_lyrics_box.innerHTML = "WATASHI NO IKIRU KATE SA";
    break;
    
    case (player.playerInfo.currentTime >= 243 && player.playerInfo.currentTime < 245):
    the_dying_message_lyrics_box.innerHTML = "nee watashi wa nido to";
    break;
    
    case (player.playerInfo.currentTime >= 245 && player.playerInfo.currentTime < 247):
    the_dying_message_lyrics_box.innerHTML = "kurai kao shinai yo";
    break;
    
    case (player.playerInfo.currentTime >= 247 && player.playerInfo.currentTime < 251.5):
    the_dying_message_lyrics_box.innerHTML = "saegiru kage mono mienu kara";
    break;
    
    case (player.playerInfo.currentTime >= 251.5 && player.playerInfo.currentTime < 254):
    the_dying_message_lyrics_box.innerHTML = "akakrui hizashi wo";
    break;
    
    case (player.playerInfo.currentTime >= 254 && player.playerInfo.currentTime < 257):
    the_dying_message_lyrics_box.innerHTML = "zonbun ni abi nagara";
    break;

    case (player.playerInfo.currentTime >= 257 && player.playerInfo.currentTime < 261):
    the_dying_message_lyrics_box.innerHTML = "'Muika' no taoru tare ta wo daita";
    break;
ы
    case (player.playerInfo.currentTime >= 270 && player.playerInfo.currentTime < 276):
    the_dying_message_lyrics_box.innerHTML = "Utsu-P - The Dying Message";
    break;
    
    default:
    the_dying_message_lyrics_box.innerHTML = "tu tutu tutu tutuTU";
  }

  if (follow) {
    timer = setTimeout(follow_player_time, promise_time);
  }
}

function onPlayerStateChange(event) {
  if(event.data == YT.PlayerState.PLAYING){
    console.log("Playing");

    follow = true;
    follow_player_time();

  } else {
    console.log("Not playing");
    clearTimeout(timer);
    follow = false;
  }
}

function onYouTubePlayerAPIReady() {
  player = new YT.Player('ytplayer', {
    height: '765',
    width: '80%',
    videoId: 'XVIsijUM_NE',
    events: {
      'onReady': follow_player_time,
      'onStateChange': onPlayerStateChange
    }
  });
}