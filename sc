const multer = require('multer');

const upload = multer({
  // Remove the .png extension requirement
  fileFilter: (req, file, cb) => {
    if (!file.originalname.match(/\.(png|jpg|jpeg|gif)$/)) {
      return cb(new Error('Only image files are allowed!'));
    }
    cb(null, true);
  }
});

// Use the upload middleware in your route
app.post('/upload', upload.single('image'), (req, res) => {
  // Handle the uploaded file
  console.log(req.file);
  res.send(`File uploaded successfully!`);
});
