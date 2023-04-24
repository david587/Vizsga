<?php

namespace App\Http\Controllers;
use App\Models\ship;

use Illuminate\Http\Request;

class ShipController extends Controller
{
    public function index()
{
    $ships = Ship::all();
    return response()->json(['data' => $ships], 201);
}

    public function show(Ship $ship)
    {

    }

    public function create()
{
    return view('ships.create');
}

public function store(Request $request)
{

    $input = $request->all();
    $ship = Ship::create($input);
    return response()->json(['data' => $ship], 201);
}


public function update(Request $request, $id)
{
   $ship = Ship::find($id);
   $ship->update($request->all());
   return response()->json(['data' => $ship], 201);
}

public function destroy($id)
{
  $ship = Ship::destroy($id);
  return response()->json(['data' => $ship], 201);
}




}
