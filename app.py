from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/process_image', methods=['POST'])
def process_image():
    if 'file' not in request.files:
        return jsonify({'error': 'No file part'}), 400

    file = request.files['file']
    if file.filename == '':
        return jsonify({'error': 'No selected file'}), 400

    # 保存图片到本地目录
    file.save(f"./{file.filename}")
    return jsonify({'message': 'Image uploaded successfully!', 'filename': file.filename}), 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
