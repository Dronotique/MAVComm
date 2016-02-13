/**
 * Generated class : msg_log_request_data
 * DO NOT MODIFY!
 **/
package org.mavlink.messages.lquac;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.mavlink.IMAVLinkCRC;
import org.mavlink.MAVLinkCRC;
import org.mavlink.messages.MAVLinkMessage;
/**
 * Class msg_log_request_data
 * Request a chunk of a log
 **/
public class msg_log_request_data extends MAVLinkMessage {
  public static final int MAVLINK_MSG_ID_LOG_REQUEST_DATA = 119;
  private static final long serialVersionUID = MAVLINK_MSG_ID_LOG_REQUEST_DATA;
  public msg_log_request_data() {
    this(1,1);
}
  public msg_log_request_data(int sysId, int componentId) {
    messageType = MAVLINK_MSG_ID_LOG_REQUEST_DATA;
    this.sysId = sysId;
    this.componentId = componentId;
    length = 12;
}

  /**
   * Offset into the log
   */
  public long ofs;
  /**
   * Number of bytes
   */
  public long count;
  /**
   * Log id (from LOG_ENTRY reply)
   */
  public int id;
  /**
   * System ID
   */
  public int target_system;
  /**
   * Component ID
   */
  public int target_component;
/**
 * Decode message with raw data
 */
public void decode(ByteBuffer dis) throws IOException {
  ofs = (int)dis.getInt()&0x00FFFFFFFF;
  count = (int)dis.getInt()&0x00FFFFFFFF;
  id = (int)dis.getShort()&0x00FFFF;
  target_system = (int)dis.get()&0x00FF;
  target_component = (int)dis.get()&0x00FF;
}
/**
 * Encode message with raw data and other informations
 */
public byte[] encode() throws IOException {
  byte[] buffer = new byte[8+12];
   ByteBuffer dos = ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN);
  dos.put((byte)0xFE);
  dos.put((byte)(length & 0x00FF));
  dos.put((byte)(sequence & 0x00FF));
  dos.put((byte)(sysId & 0x00FF));
  dos.put((byte)(componentId & 0x00FF));
  dos.put((byte)(messageType & 0x00FF));
  dos.putInt((int)(ofs&0x00FFFFFFFF));
  dos.putInt((int)(count&0x00FFFFFFFF));
  dos.putShort((short)(id&0x00FFFF));
  dos.put((byte)(target_system&0x00FF));
  dos.put((byte)(target_component&0x00FF));
  int crc = MAVLinkCRC.crc_calculate_encode(buffer, 12);
  crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
  byte crcl = (byte) (crc & 0x00FF);
  byte crch = (byte) ((crc >> 8) & 0x00FF);
  buffer[18] = crcl;
  buffer[19] = crch;
  return buffer;
}
public String toString() {
return "MAVLINK_MSG_ID_LOG_REQUEST_DATA : " +   "  ofs="+ofs+  "  count="+count+  "  id="+id+  "  target_system="+target_system+  "  target_component="+target_component;}
}
