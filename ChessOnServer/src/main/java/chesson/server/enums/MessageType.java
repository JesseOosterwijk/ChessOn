package chesson.server.enums;

public enum MessageType {
    REGISTER,
    LOGIN,
    LOGOUT,
    CREATE_LOBBY,
    JOIN_LOBBY,
    NOTIFY_WHEN_READY,
    PLAYER_READY,
    WAIT_FOR_OTHER_PLAYER,
    START_GAME,
    MOVE_PIECE,
    SWITCH_TURN,
    GAME_NOT_FOUND_ERROR,
    SET_PLAYER,
    SET_OPPONENT
}
