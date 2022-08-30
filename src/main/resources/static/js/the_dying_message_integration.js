//ytplayer code: 
//https://developers.google.com/youtube/player_parameters#IFrame_Player_API
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/player_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
var follow = false;
var timer = setTimeout(() => follow_player_time, 1000);
var the_dying_message_lyrics_box = document.getElementById("the_dying_message_lyrics_box");

function follow_player_time() {
  console.log("Current time: " + player.playerInfo.currentTime);
// thanks to this:
// https://stackoverflow.com/questions/21808543/multple-criteria-in-a-single-case-inside-a-switch-statement?noredirect=1&lq=1
  switch(true){

    case (player.playerInfo.currentTime >= 20 && player.playerInfo.currentTime < 21):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "Sanman de";
    break;

    case (player.playerInfo.currentTime >= 21 && player.playerInfo.currentTime < 22):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "fuantei na";
    break;

    case (player.playerInfo.currentTime >= 22 && player.playerInfo.currentTime < 23):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "kono sekai";
    break;

    case (player.playerInfo.currentTime >= 23 && player.playerInfo.currentTime < 27):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "Kakumei ho okoshite yo";
    break;

    case (player.playerInfo.currentTime >= 28 && player.playerInfo.currentTime < 29):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 30 && player.playerInfo.currentTime < 31):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "fuante nantei";
    break;

    case (player.playerInfo.currentTime >= 31 && player.playerInfo.currentTime < 33):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "kankani kiechate";
    break;

    case (player.playerInfo.currentTime >= 33 && player.playerInfo.currentTime < 34):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "hakumei no";
    break;

    case (player.playerInfo.currentTime >= 34 && player.playerInfo.currentTime < 35):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "hi terasu";
    break;

    case (player.playerInfo.currentTime >= 35 && player.playerInfo.currentTime < 39):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "sono mukou hee";
    break;

    case (player.playerInfo.currentTime >= 40 && player.playerInfo.currentTime < 41):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "Kiroku mo";
    break;

    case (player.playerInfo.currentTime >= 41 && player.playerInfo.currentTime < 42):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "kioku mo";
    break;

    case (player.playerInfo.currentTime >= 43 && player.playerInfo.currentTime < 44):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "nai hito maishou";
    break;

    case (player.playerInfo.currentTime >= 44 && player.playerInfo.currentTime < 45):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "asd";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    case (player.playerInfo.currentTime >= 10 && player.playerInfo.currentTime < 11):
    console.log("In condition: " + player.playerInfo.currentTime);
    the_dying_message_lyrics_box.innerHTML = "'Ai' ga seikai ni nare";
    break;

    default:
    the_dying_message_lyrics_box.innerHTML = "tu tutu tutu tutuTU";
  }

  if (follow) {
    timer = setTimeout(follow_player_time, 1000);
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