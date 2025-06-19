# Code from 
#   https://github.com/Sketchware-Pro/Sketchware-Pro/tree/main/.github/workflows/deploay_artifacts.py
# thanks ilyassealama
from telethon import TelegramClient
import os

# Telegram API credentials
api_id = int(os.getenv("API_ID"))
api_hash = os.getenv("API_HASH")
bot_token = os.getenv("BOT_TOKEN")
group_id = int(os.getenv("CHAT_ID"))

# File paths to send
apk_to_send = os.getenv("APK_TO_SEND")

# Create the client with bot token directly
os.remove('bot_session.session') if os.path.exists('bot_session.session') else None
client = TelegramClient('bot_session', api_id, api_hash).start(bot_token=bot_token)
client.parse_mode = 'markdown'


def human_readable_size(size, decimal_places=2):
    for unit in ['B', 'KB', 'MB', 'GB', 'TB']:
        if size < 1024.0:
            break
        size /= 1024.0
    return f"{size:.{decimal_places}f} {unit}"


async def progress(current, total):
    progress_percentage = (current / total) * 100
    uploaded_size_readable = human_readable_size(current)
    total_size_readable = human_readable_size(total)
    print(f"{progress_percentage:.2f}% uploaded - {uploaded_size_readable}/{total_size_readable}", end='\r')


async def send_file(file_path):
    if not os.path.exists(file_path):
        print("File not found", file_path)
        return

    print(f"Sending file: {file_path} to the Telegram group")

    message = os.getenv("DESCRIPTION")
    topic_id = os.getenv("TOPIC_ID")

    try:
        kwargs = {
            "entity": group_id,
            "file": file_path,
            "parse_mode": 'markdown',
            "caption": message,
            "progress_callback": progress,
        }

        if topic_id:
            kwargs["reply_to"] = int(topic_id)

        await client.send_file(**kwargs)
        print("\nFile sent successfully")
    except Exception as e:
        print(f"Failed to send file: {e}")

try:
    with client:
        client.loop.run_until_complete(send_file(apk_to_send))
finally:
    if client.is_connected():
        client.loop.run_until_complete(client.disconnect())
