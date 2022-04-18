package com.example.myapplication.serialization

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.TypeParceler
import kotlinx.parcelize.WriteWith


data class Phone(
    val model: String
)

object PhoneClassParceler : Parceler<Phone> {
    override fun create(parcel: Parcel): Phone {
        return Phone(parcel.readString() ?: "iPhone")
    }

    override fun Phone.write(parcel: Parcel, flags: Int) {
        parcel.writeString(model)
    }

}

@Parcelize
@TypeParceler<Phone, PhoneClassParceler>()
data class PhoneOwner(val phone: Phone) : Parcelable

@Parcelize
data class PhoneOwner1(@TypeParceler<Phone, PhoneClassParceler>() val phone: Phone) : Parcelable

@Parcelize
data class PhoneOwner2(val phone: @WriteWith<PhoneClassParceler>() Phone) : Parcelable

data class Pet(
    val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "pet")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }
}

data class Person(
    val id: Long,
    var name: String,
    var age: Int,
    var isStudent: Boolean,
    var pets: List<Pet>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.createTypedArrayList(Pet) ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeByte(if (isStudent) 1 else 0)
        parcel.writeTypedList(pets)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}
