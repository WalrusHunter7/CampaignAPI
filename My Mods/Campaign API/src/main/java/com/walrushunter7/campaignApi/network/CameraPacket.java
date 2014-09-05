package com.walrushunter7.campaignApi.network;

import com.walrushunter7.campaignApi.camera.CameraHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class CameraPacket implements IMessage, IMessageHandler<CameraPacket,IMessage> {

    private byte packetId;
    private int cameraId;

    public CameraPacket() {

    }

    public CameraPacket(byte packetId, int cameraId) {
        this.packetId = packetId;
        this.cameraId = cameraId;
    }

    /* IDs
     *
     * 1 = start
     * 2 = stop
     * 3 = new camera
     * 4 = set camera
     * 5 = delete camera
     */


    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(packetId);
        buf.writeByte(cameraId);
        switch (packetId) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.packetId = buf.readByte();
        this.cameraId = buf.readByte();
        switch (packetId) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }

    @Override
    public IMessage onMessage(CameraPacket message, MessageContext ctx) {


        switch (message.packetId) {
            case 1:

                break;
            case 2:
                CameraHandler.normalPlayerCamera();
                break;
            case 3:
                CameraHandler.newCamera(message.cameraId);
                break;
            case 4:
                CameraHandler.setPlayerCamera(message.cameraId);
                break;
            case 5:
                CameraHandler.removeCamera(message.cameraId);
                break;
        }

        return null;
    }

}
