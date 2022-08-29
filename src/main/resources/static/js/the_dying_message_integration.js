//ytplayer code: https://developers.google.com/youtube/player_parameters#IFrame_Player_API
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/player_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
var follow = false;
var timer = setTimeout(() => follow_player_time, 1000);

function follow_player_time() {

  console.log("Current time: " + player.playerInfo.currentTime);

  if (player.playerInfo.currentTime >= 12 && player.playerInfo.currentTime < 13) {
    console.log("In condition: " + player.playerInfo.currentTime);
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