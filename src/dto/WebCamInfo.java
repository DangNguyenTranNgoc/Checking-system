/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class WebCamInfo {

    private String _WebCamName;
    private int _WebCamIndex;

    public String getWebCamName() {
        return _WebCamName;
    }

    public void setWebCamName(String _WebCamName) {
        this._WebCamName = _WebCamName;
    }

    public int getWebCamIndex() {
        return _WebCamIndex;
    }

    public void setWebCamIndex(int _WebCamIndex) {
        this._WebCamIndex = _WebCamIndex;
    }

    @Override
    public String toString() {
        return "WebCam{" + "_WebCamName=" + _WebCamName + ", _WebCamIndex=" + _WebCamIndex + '}';
    }

}
