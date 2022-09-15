//ytplayer code: 
//https://developers.google.com/youtube/player_parameters#IFrame_Player_API
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/player_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
var follow = false;
var timer = setTimeout(() => follow_player_time, 500);
var the_dying_message_lyrics_box = document.getElementById("the_dying_message_lyrics_box");

function follow_player_time() {
  console.log("Current time: " + player.playerInfo.currentTime);
// thanks to this guy's replay:
// https://stackoverflow.com/questions/21808543/multple-criteria-in-a-single-case-inside-a-switch-statement?noredirect=1&lq=1
  
// Switch below takes the time in the player and for specific range of seconds displays
// lyrics in the song overriding over and over again the same object 
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
    the_dying_message_lyrics_box.innerHTML = "Kakumei ho okoshite yo";
    break;

    case (player.playerInfo.currentTime >= 28 && player.playerInfo.currentTime < 29.5):
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 30 && player.playerInfo.currentTime < 31):
    the_dying_message_lyrics_box.innerHTML = "fuante nantei";
    break;

    case (player.playerInfo.currentTime >= 31 && player.playerInfo.currentTime < 33.5):
    the_dying_message_lyrics_box.innerHTML = "kankani kiechate";
    break;

    case (player.playerInfo.currentTime >= 33.5 && player.playerInfo.currentTime < 35):
    the_dying_message_lyrics_box.innerHTML = "hakumei no";
    break;

    case (player.playerInfo.currentTime >= 35 && player.playerInfo.currentTime < 36):
    the_dying_message_lyrics_box.innerHTML = "hi terasu";
    break;

    case (player.playerInfo.currentTime >= 36.5 && player.playerInfo.currentTime < 39):
    the_dying_message_lyrics_box.innerHTML = "sono mukou hee";
    break;

    case (player.playerInfo.currentTime >= 40 && player.playerInfo.currentTime < 41):
    the_dying_message_lyrics_box.innerHTML = "Kiroku mo";
    break;

    case (player.playerInfo.currentTime >= 41 && player.playerInfo.currentTime < 42):
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

    case (player.playerInfo.currentTime >= 52 && player.playerInfo.currentTime < 53.5):
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

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 67 && player.playerInfo.currentTime < 68):
    the_dying_message_lyrics_box.innerHTML = "SEKAI DEEE";
    break;

    case (player.playerInfo.currentTime >= 68 && player.playerInfo.currentTime < 70):
    the_dying_message_lyrics_box.innerHTML = "YAOKE MAE NO UREI";
    break;

    case (player.playerInfo.currentTime >= 70.5 && player.playerInfo.currentTime < 72):
    the_dying_message_lyrics_box.innerHTML = "TAEGATAI KODOKU";
    break;

    case (player.playerInfo.currentTime >= 74 && player.playerInfo.currentTime < 76.5):
    the_dying_message_lyrics_box.innerHTML = "AWAI OMOI TO";
    break;

    case (player.playerInfo.currentTime >= 76.5 && player.playerInfo.currentTime < 78):
    the_dying_message_lyrics_box.innerHTML = "WO";
    break;

    case (player.playerInfo.currentTime >= 78 && player.playerInfo.currentTime < 79):
    the_dying_message_lyrics_box.innerHTML = "DAITAAAAAAAAA";
    break;

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    case (player.playerInfo.currentTime >= 63.5 && player.playerInfo.currentTime < 66):
    the_dying_message_lyrics_box.innerHTML = "OWARI KAKE NO KONO";
    break;

    default:
    the_dying_message_lyrics_box.innerHTML = "tu tutu tutu tutuTU";
  }

  if (follow) {
    timer = setTimeout(follow_player_time, 500);
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