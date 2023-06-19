package hu.menetrendekplus.backend.model.request;

public enum FunctionType {

    GET_ROUTES("getRoutes"),
    GET_STATION("getStationOrAddrByTextC");

    public final String funcName;

    FunctionType(String funcName) {
        this.funcName = funcName;
    }
}
